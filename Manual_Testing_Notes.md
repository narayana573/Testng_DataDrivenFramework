# Manual Testing Concepts (Interview Notes)

---

## Core Testing Terminology

### Smoke Testing
- A quick, wide-scope testing to ensure basic functionalities work.
- Performed on every build before deeper testing.

### Sanity Testing
- Narrow, focused testing on a specific module or function after changes.
- Ensures bug fixes or enhancements work as intended.

### Retesting
- Re-execution of failed test cases after the defect is fixed.
- Specific and targeted.

### Regression Testing
- Ensures recent changes haven't broken existing features.
- Covers passed test cases and related modules.
- Best suited for automation.

---

## Test Case vs Test Suite

### Test Case
- A set of actions to verify a specific feature.
- Includes: Test Steps, Test Data, Preconditions, Expected Result, etc.

### Test Suite
- A collection of test cases grouped logically.
- Used for validating a module or functionality set.

---

## Severity vs Priority

| Criteria   | Severity                                    | Priority                                      |
|------------|---------------------------------------------|-----------------------------------------------|
| Definition | Impact of defect on functionality           | Urgency to fix the defect                     |
| Set by     | Tester                                       | Product Manager / Dev Lead                    |
| Focus      | Technical impact                             | Business or time-critical need                |
| Example    | Crash on login – High Severity               | Logo misalignment – Low Priority              |

### Severity Types
- Critical
- Major
- Moderate
- Minor
- Cosmetic

### Priority Types
- High
- Medium
- Low

---

## Test Plan vs Test Strategy

### Test Plan
- **Scope**: Specific to a project.
- **Prepared by**: Test Lead / QA Manager
- **Includes**:
  - Test objectives, features to be tested
  - Test types, entry/exit criteria
  - Resources, schedules, risks, tools

### Test Strategy
- **Scope**: Organization/program level
- **Prepared by**: QA Manager / Test Architect
- **Includes**:
  - Overall approach, environment setup
  - Automation strategy, defect process
  - Reporting and quality metrics

| Aspect            | Test Plan                          | Test Strategy                      |
|-------------------|-------------------------------------|------------------------------------|
| Level             | Project-specific                    | Organization-wide                  |
| Detail            | Detailed and actionable             | High-level guidance                |
| Dynamic/Static    | Dynamic (may change per project)    | Static (rarely changes)            |

---

## Retesting vs Regression Testing

| Criteria             | Retesting                             | Regression Testing                              |
|----------------------|----------------------------------------|-------------------------------------------------|
| Purpose              | Verify bug fixes                       | Ensure new changes haven't affected old code    |
| Test Cases           | Failed cases only                      | Passed + related cases                          |
| Trigger              | After defect fix                       | After any code change                           |
| Automation           | Rarely automated                       | Commonly automated                              |
| Scope                | Narrow                                 | Broad                                           |

---

## SDLC vs STLC

### SDLC – Software Development Life Cycle
- Phases:
  1. Requirement Gathering
  2. Feasibility Study
  3. Design (HLD & LLD)
  4. Development
  5. Testing
  6. Deployment
  7. Maintenance

### STLC – Software Testing Life Cycle
- Phases:
  1. Requirement Analysis
  2. Test Planning
  3. Test Case Design
  4. Test Environment Setup
  5. Test Execution
  6. Defect Reporting
  7. Test Closure

| Aspect              | SDLC                                  | STLC                                |
|---------------------|----------------------------------------|--------------------------------------|
| Focus               | Entire development lifecycle           | Only testing phase                   |
| Starts With         | Requirement gathering                  | When requirements are ready          |
| Output              | Working software                       | Verified/tested software             |
| Involves            | BA, Dev, QA, PM                        | Only QA/Test team                    |

---

## Bug / Defect Concepts

### Bug / Defect
- Deviation from expected behavior.
- Found during testing and reported using bug tracking tools.

### Bug Life Cycle
1. New
2. Assigned
3. Open
4. Fixed
5. Retest
6. Closed
7. Reopened
8. Rejected
9. Deferred
10. Duplicate

### Defect Report – Key Fields
- ID, Summary, Description
- Steps to Reproduce
- Expected vs Actual Results
- Severity, Priority
- Environment
- Status, Assigned To, Attachments

---

## Bug Triage
- A collaborative process to review and prioritize defects.
- Participants: QA, Dev Leads, Product Owner, PM
- Goals:
  - Prioritize important bugs
  - Defer or reject irrelevant ones
  - Ensure fixes align with deadlines

---

## Additional Tips for Interviews

- STLC is a **subset of SDLC** focused on quality.
- Use real-time **examples** while explaining each concept.
- Be clear about who performs what (QA, Dev, PM, etc.)
- Understand **tools** used for each phase (e.g., Jira, TestLink, Postman).

---
