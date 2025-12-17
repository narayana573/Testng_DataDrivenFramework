#### Manual Testing

> <b>Smoke testing</b> is a wide approach where all areas of the software application are tested without getting into too deep.
 
> <b>sanitysoftware testing</b> is a narrow regression testing with a focus on one or a small set of areas of functionality of the software application.

> <b>Retesting</b> is done to make sure that the tests cases which failed in last execution are passing after the defects against those failures are fixed.

> <b>Regression testing</b> is not carried out on specific defect fixes. ... InRegression testing, you can include the test cases which passed earlier.


> <b>Test Case:</b> A TEST CASE is a set of actions executed to verify a particular feature or functionality of your software application. A Test Case contains test steps, test data, precondition, postcondition developed for specific test scenario to verify any requirement.


> <b>Test Suite:</b> as “validation suite,” a test suite is a collection of various test cases that are intended to test a software product or its specific functionality/feature, once the software development is accomplished.


> <b>Severity:</b> Defect Severity is defined as the degree of impact that a defect has on the operation of the product

**Severity is categorized into five types**
* Critical
* Major
* Moderate
* Minor
* Cosmetic


> <b>Priority:</b> Defect Priority has defined the order in which the developer should resolve a defect

**Priority is categorized into three types**
* Low
* Medium
* High





## Test Plan vs Test Strategy (Interview Notes)

### Test Plan

- **Definition**: A detailed document describing the scope, approach, resources, and schedule of testing activities.
- **Objective**: To outline how testing will be carried out for a specific project.
- **Prepared by**: Test Lead / QA Manager
- **Scope**:
  - Test objectives
  - Test items (features to be tested)
  - Types of testing (Functional, Regression, Smoke, etc.)
  - Testing schedule & milestones
  - Entry and Exit criteria
  - Resources and responsibilities
  - Risk identification & mitigation
  - Tools to be used

- **Project-specific**: Yes
- **Example**: Test plan for an e-commerce checkout feature

---

### Test Strategy

- **Definition**: A high-level document that outlines the general approach and principles for testing across the organization or program.
- **Objective**: To define the overall testing approach and standards to be followed.
- **Prepared by**: QA Manager / Test Architect
- **Scope**:
  - Testing approach for all phases
  - Test levels and test types
  - Test environment setup
  - Defect management process
  - Automation strategy
  - Metrics and reporting standards

- **Project-specific**: No (applies across multiple projects)
- **Example**: Organization-wide test strategy defining how automation will be handled across all products

---

### Key Differences

| Aspect            | Test Plan                        | Test Strategy                         |
|-------------------|----------------------------------|----------------------------------------|
| Level             | Project level                    | Organization or program level          |
| Prepared by       | Test Lead / QA Manager           | QA Manager / Test Architect            |
| Focus             | What, when, who, and how of testing for a project | Overall testing principles and approach |
| Dynamic/Static    | Dynamic – changes per project    | Static – rarely changes                |
| Detail            | Detailed & actionable            | High-level & directional               |






## Retesting vs Regression Testing (Interview Notes)

### Retesting

- **Definition**: Testing the specific test cases that failed in the previous execution after defects are fixed.
- **Objective**: To verify that the defect is fixed and the functionality is working as expected.
- **Focus**: Only on the failed test cases.
- **Test Cases**: Same test cases that failed earlier.
- **Requires Defect Fix?**: Yes
- **Automation Feasibility**: Usually not automated; often done manually.
- **Example**: Login button was not working due to a bug. After the fix, the same login test case is executed again to confirm the issue is resolved.

---

### Regression Testing

- **Definition**: Testing the unchanged parts of the application to ensure that new code changes have not impacted existing functionality.
- **Objective**: To ensure stability of the application after changes.
- **Focus**: On affected and surrounding areas of the code.
- **Test Cases**: Includes passed test cases + related functionalities.
- **Requires Defect Fix?**: Not always
- **Automation Feasibility**: Highly suitable for automation.
- **Example**: After a change in the payment module, tests are executed on the entire checkout process to confirm no existing feature is broken.

---

### Key Differences

| Aspect               | Retesting                          | Regression Testing                           |
|----------------------|------------------------------------|-----------------------------------------------|
| Purpose              | Confirm bug fix                    | Confirm unchanged code is not broken          |
| Based on             | Bug fixes                          | Code changes, enhancements, or bug fixes      |
| Scope                | Narrow (failed test cases only)    | Broad (related and surrounding functionalities) |
| Test Case Reuse      | Same test case re-executed         | Existing test suite executed                  |
| Automation           | Rarely automated                   | Commonly automated                            |
| Dependency           | Depends on defect fix              | Depends on any code change                    |






## SDLC vs STLC (Interview Notes)

### SDLC – Software Development Life Cycle

- **Definition**: A process followed for software development, defining phases from requirement gathering to maintenance.
- **Objective**: To ensure software is developed systematically with proper planning and control.
- **Phases**:
  - Requirement Gathering
  - Feasibility Study
  - Design (HLD & LLD)
  - Development
  - Testing
  - Deployment
  - Maintenance
- **Participants**: Business Analysts, Architects, Developers, Testers, Project Managers, Clients
- **Deliverables**:
  - SRS (Software Requirement Specification)
  - Design Documents
  - Source Code
  - Test Plans
  - Deployment Plans

---

### STLC – Software Testing Life Cycle

- **Definition**: A sequence of activities performed during the testing process to ensure software quality.
- **Objective**: To validate and verify that the software meets the business and technical requirements.
- **Phases**:
  - Requirement Analysis
  - Test Planning
  - Test Case Design
  - Test Environment Setup
  - Test Execution
  - Defect Reporting & Tracking
  - Test Closure
- **Participants**: QA/Test Managers, Test Leads, Test Engineers
- **Deliverables**:
  - Test Plan
  - Test Cases/Scripts
  - Test Data
  - Defect Reports
  - Test Summary Report

---

### Key Differences

| Aspect                | SDLC                                  | STLC                                     |
|-----------------------|----------------------------------------|-------------------------------------------|
| Full Form             | Software Development Life Cycle        | Software Testing Life Cycle               |
| Focus Area            | Entire software development process    | Only testing-related activities           |
| Involves              | BA, Dev, QA, PM                        | Only QA/Testing team                      |
| Starts From           | Requirement gathering                  | Once requirements are ready               |
| Output                | Working Software                       | Verified/Tested Software                  |
| Deliverables          | Code, Design Docs, User Manuals        | Test Plan, Test Cases, Defect Reports     |

---

### Tip for Interview
- **Remember**: STLC is a part of SDLC, focusing only on quality assurance and validation phases.
