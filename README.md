# Portfolio Artifacts for CS320

## Submitted Artifacts
- **Project One**:
  - `Contact.java`
  - `ContactService.java`
  - `ContactTest.java`
  - `ContactServiceTest.java`
- **Project Two**:
  - Summary and Reflections Report

## Artifacts
- **Contact.java**: Defines the `Contact` class with attributes such as `id`, `name`, `phone`, and `address`. Includes input validation to ensure valid contact details.
- **ContactService.java**: Provides functionality to manage `Contact` objects, including adding, deleting, and updating contacts while maintaining unique IDs.
- **ContactTest.java**: Contains JUnit tests to validate the `Contact` class, focusing on data integrity and edge cases.
- **ContactServiceTest.java**: Includes JUnit tests to validate the `ContactService`, ensuring proper functionality and handling of invalid operations.


## Project Structure
```
ProjectOne/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │       ├── AppointmentService/
│   │       │   ├── Appointment.java
│   │       │   ├── AppointmentService.java
│   │       ├── ContactService/
│   │       │   ├── Contact.java
│   │       │   ├── ContactService.java
│   │       ├── TaskService/
│   │           ├── Task.java
│   │           ├── TaskService.java
│   ├── test/
│       ├── java/
│           ├── AppointmentService/
│           │   ├── AppointmentServiceTest.java
│           │   ├── AppointmentTest.java
│           ├── ContactService/
│           │   ├── ContactServiceTest.java
│           │   ├── ContactTest.java
│           ├── TaskService/
│               ├── TaskServiceTest.java
│               ├── TaskTest.java
│
├── pom.xml
└── README.md
```

## Reflection

### How can I ensure that my code, program, or software is functional and secure?
To ensure functionality and security, I adhere to systematic testing practices and incorporate rigorous test-driven development (TDD) principles. Writing unit tests for edge cases, validating inputs, and ensuring proper error handling are central to my approach. For example, in Project One, I designed JUnit tests to validate unique IDs and constraints on contact fields. These efforts minimize vulnerabilities and enhance code reliability.

### How do I interpret user needs and incorporate them into a program?
Interpreting user needs involves closely analyzing project requirements and designing features that address those needs effectively. In Project Two, I focused on services such as `AppointmentService` to validate constraints like valid dates and non-null IDs, ensuring that user-facing functionality met defined requirements. Incorporating feedback and considering usability are also vital aspects of this process.

### How do I approach designing software?
My approach to software design is methodical and requirement-driven. The foundation of successful software lies in well-defined and comprehensive requirements, as they provide the roadmap for achieving client satisfaction. By thoroughly understanding and documenting requirements, I ensure that the software directly addresses client needs and expectations, which is critical for maintaining customer-centric solutions (CCS).

To achieve this, I employ best practices like modular development and test-driven development (TDD). These techniques help align each component with the system's goals while ensuring that the software is maintainable, scalable, and adaptable to future enhancements. For example, in Project One, I structured the ContactService to encapsulate logic, allowing for flexibility and straightforward updates as requirements evolve.

Driving toward CCS means continually validating the design against client expectations and iterating based on feedback. This mindset fosters not only robust and reliable software but also builds trust and long-term relationships with clients, as their satisfaction remains at the core of every development decision.
