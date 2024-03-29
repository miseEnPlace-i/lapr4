# User Story 2003 - List Exams in a Course

> As Teacher, I want to view a list of all exams in a course.

|             |           |
| ----------- | --------- |
| ID          | 23        |
| Sprint      | B         |
| Application | 3 - Exams |
| Priority    | 1         |

## Acceptance Criteria

- N/A.

## 2.1 Client Specifications

- N/A

## 2.2. Client Clarifications

- N/A

## 2.3. Functional Requirements

> **FRE03** List Course Exams - The system displays to a teacher of a course all the exams of the course.

## 2.4. Acceptance Criteria

- N/A

## 3. Analysis

### 3.1. Main success scenario

1. Teacher requests to view all the exams in a course
2. The system displays all the available courses
3. Teacher selects the desired course
4. The system display all the exams in the course

### 3.2. Conditions

- The teacher must be authenticated.

### 3.3. System Sequence Diagram

![US2003_SSD](out/US2003_SSD.svg)

### 3.4. Sequence Diagram (Simplified)

![US2003_SD](out/US2003_SD.svg)

### 3.5. Partial Domain Model

![US2003_DM](out/US2003_DM.svg)

## 4. Design

### 4.1. Functionality Realization

![US2003_SD](out/US2003_SD.svg)

### 4.2. Class Diagram

![US2003_CD](out/US2003_CD.svg)

### 4.3. Applied Patterns

- **Dependency Injection:** This is used in the controller and in the services. This is done to enable the use of a mock repository in the tests and to reduce coupling.
- **Repository:** This is used to store the courses and exams. This is done to reduce coupling and to allow the use of the repository in other parts of the application.
- **Service:** This is used to provide a list of courses and exams to the controller. This is done to reduce coupling and to allow the use of the service in other parts of the application.

### 4.4. Tests

- N/A

## 5. Implementation

### 5.1. Controller

- Relevant implementation details

```java
  public Iterable<CourseDTO> listOpenInProgressCourses() {
  Iterable<CourseDTO> openCourses = this.service.listOpenCourses();

  Iterable<CourseDTO> inProgressCourses = this.service.listInProgressCourses();
  Stream<CourseDTO> combinedStream = Stream.concat(StreamSupport.stream(openCourses.spliterator(), false),
  StreamSupport.stream(inProgressCourses.spliterator(), false));

  return combinedStream::iterator;
  }

public Iterable<EvaluationExamDTO> listCourseEvaluationExams(CourseDTO courseDTO) {
  authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER, ClientRoles.MANAGER);

  Optional<Course> course = courseRepository.ofIdentity(courseDTO.getCode());

  if (course.isEmpty())
  throw new IllegalArgumentException("There is no Course with the given code");

  return evaluationExamService.listAllCourseExams(course.get());
  }

public Iterable<FormativeExamDTO> listCourseFormativeExams(CourseDTO courseDTO) {
  Course course = courseRepository.ofIdentity(courseDTO.getCode()).orElseThrow();
  return formativeExamService.findAllCourseExams(course);
  }
```

## 6. Integration & Demonstration

## 6. Integration & Demonstration

### 6.1. Success scenario

![US2003_DEMO](US2003_DEMO.png)

### 6.2. Failure scenarios

#### 6.2.1. No exams in the course

![US2003_DEMO_FAIL](US2003_DEMO_FAIL.png)

## 7. Observations

N/a
