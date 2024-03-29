const RETRY_TIMEOUT = 3000;
const ERROR_TIMEOUT = 1000;
const REFRESH_TIMEOUT = 2000;
const MAX_TIMEOUT = 10000;

const boardSelector = document.querySelector("#board-selector");
let t, authT, boardT;
let authenticated;

function showError(message) {
  const error = document.querySelector("#error");

  error.innerHTML = `
    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-y relative w-1/2 mx-auto rounded" role="alert">
      <strong class="font-bold">Error!</strong>
      <span class="block sm:inline">${message}</span>
      <div class="animate-spin duration-150 transition-all">↻</div>
    </div>
  `;
}

function clearError() {
  const error = document.querySelector("#error");
  error.innerHTML = "";
}

/** @type {(data:{archived: string | null, columns: {number: number, title: string}[], rows: {number: number, title: string}[], id: string, owner: {username: string, name: string, email: string}, permissions: {createdAt: string, type: string, updatedAt: string, user: {username: string, name: string, email: string}}[], title: string}[], authenticatedUser: {username: string, name: string, email: string, roles: string[]})=>{boardId:string, title: string, permission: "READ" | "WRITE", archived: string | null}[]} */
function getUserPermissions(data, authenticatedUser) {
  const result = [];

  for (const board of data) {
    if (board.owner.username === authenticatedUser.username) {
      result.push({
        title: board.title,
        permission: "OWNER",
        boardId: board.id,
        archived: board.archived,
      });
      continue;
    }
    for (const permission of board.permissions) {
      if (permission.user.username === authenticatedUser.username) {
        result.push({
          title: board.title,
          permission: permission.type,
          boardId: board.id,
          archived: board.archived,
        });
      }
    }
  }

  return result;
}

function getData() {
  getUserBoards();
  getAuthenticatedUser();
  getOnlineUsers();
}

function getUserBoards() {
  console.log("> Getting user boards");
  /** @type XMLHttpRequest */
  let request;
  clearTimeout(boardT);

  try {
    request = new XMLHttpRequest();
  } catch (error) {
    throw new Error("Could not create HTTP request object.");
  }

  request.onload = () => {
    clearError();
    boardT = setTimeout(getUserBoards, REFRESH_TIMEOUT);

    if (request.status === 401) {
      boardSelector.innerHTML = `<option selected="selected" value disabled
      class="dark:bg-slate-600 bg-slate-200">Please login!</option>`;
      boardSelector.disabled = true;

      return;
    }
    boardSelector.innerHTML =
      '<option selected="selected" value disabled class="dark:bg-slate-600 bg-slate-200">-- Select a board --</option>';
    boardSelector.disabled = false;

    /** @type {{archived: string | null, columns: {number: number, title: string}[], rows: {number: number, title: string}[], id: string, owner: {username: string, name: string, email: string}, permissions: {createdAt: string, type: string, updatedAt: string, user: {username: string, name: string, email: string}}[], title}[]} */
    const data = JSON.parse(request.responseText);

    // as the request is asynchronous, authenticated might not be set yet
    if (!authenticated) {
      boardT = setTimeout(getUserBoards, 200);
      return;
    }

    const userPerms = getUserPermissions(data, authenticated);

    for (const permission of userPerms)
      boardSelector.innerHTML += `<option value=${
        permission.boardId
      } class="dark:bg-slate-600 bg-slate-200 py-2 text-md">${
        permission.title
      } ${
        permission.permission === "OWNER"
          ? "👑"
          : permission.permission === "READ"
          ? "👁"
          : "✏️"
      } ${permission.archived ? "(Archived)" : ""}</option>`;
  };

  request.ontimeout = () => {
    showError("Server timeout, still trying...");
    boardT = setTimeout(getUserBoards, ERROR_TIMEOUT);
  };
  request.onerror = () => {
    showError("No server reply, still trying...");
    boardT = setTimeout(getUserBoards, RETRY_TIMEOUT);
  };

  request.open("GET", "/api/board", true);
  request.timeout = MAX_TIMEOUT;
  request.send(null);
}

function getAuthenticatedUser() {
  console.log("> Getting authenticated user");

  /** @type XMLHttpRequest */
  let authRequest;
  clearTimeout(authT);

  try {
    authRequest = new XMLHttpRequest();
  } catch (error) {
    throw new Error("Could not create HTTP Request object.");
  }

  const username = document.querySelector("#user");

  authRequest.onload = () => {
    clearError();
    authT = setTimeout(getAuthenticatedUser, REFRESH_TIMEOUT);

    if (authRequest.status === 401) {
      username.innerHTML = "Unauthenticated";
    } else {
      /** @type {{username: string, name: string, email: string, roles: string[]}} */
      const data = JSON.parse(authRequest.responseText);
      username.innerHTML = `Welcome, ${data.username}!`;
      authenticated = data;
    }
  };

  authRequest.ontimeout = () => {
    showError("Server timeout, still trying...");
    authT = setTimeout(getAuthenticatedUser, ERROR_TIMEOUT);
  };
  authRequest.onerror = () => {
    showError("No server reply, still trying...");
    authT = setTimeout(getAuthenticatedUser, RETRY_TIMEOUT);
  };

  authRequest.open("GET", "/api/session", true);
  authRequest.timeout = MAX_TIMEOUT;
  authRequest.send(null);
}

function getOnlineUsers() {
  console.log("> Getting online users");

  /** @type XMLHttpRequest */
  let onlineUsersRequest;
  clearTimeout(t);

  try {
    onlineUsersRequest = new XMLHttpRequest();
  } catch (error) {
    throw new Error("Could not create HTTP Request object.");
  }

  const online = document.querySelector("#online");

  onlineUsersRequest.onload = () => {
    clearError();

    /** @type {{online: number}} */
    const data = JSON.parse(onlineUsersRequest.responseText);

    online.innerHTML = `Currently active: ${data.online}`;
    setTimeout(getOnlineUsers, REFRESH_TIMEOUT);
  };

  onlineUsersRequest.ontimeout = () => {
    showError("Server timeout, still trying...");
    setTimeout(getOnlineUsers, ERROR_TIMEOUT);
  };
  onlineUsersRequest.onerror = () => {
    showError("No server reply, still trying...");
    setTimeout(getOnlineUsers, RETRY_TIMEOUT);
  };

  onlineUsersRequest.open("GET", "/api/online", true);
  onlineUsersRequest.timeout = MAX_TIMEOUT;
  onlineUsersRequest.send(null);
}

const button = document.querySelector("#confirm-button");
button.addEventListener("click", (e) => {
  e.preventDefault();
  const boardSelector = document.querySelector("#board-selector");
  const boardName = boardSelector.options[boardSelector.selectedIndex].value;
  if (boardName === "") return alert("Please select a board.");
  else window.location.href = `/board.html?board=${boardName}`;
});
