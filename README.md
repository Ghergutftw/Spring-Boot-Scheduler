# Spring Boot Scheduler

A lightweight task scheduler application built with Spring Boot that supports both scheduled and manual task triggers.

## Overview

This application demonstrates a Spring Boot-based scheduler system with the following features:
- **Automatic Scheduled Tasks**: Tasks that run automatically at fixed intervals (5-second delay by default)
- **Manual Task Triggering**: REST API endpoints to manually trigger and monitor tasks
- **Task Status Tracking**: Real-time status monitoring with timestamps
- **CORS Support**: Configured for cross-origin requests (localhost:4200)

## Project Structure

```
scheduler/
├── src/
│   ├── main/
│   │   ├── java/com/example/scheduler/
│   │   │   ├── SchedulerApplication.java      # Main Spring Boot application
│   │   │   ├── TaskController.java             # REST API endpoints
│   │   │   ├── TaskService.java                # Business logic & scheduling
│   │   │   └── TaskStatus.java                 # Status record
│   │   └── resources/
│   │       └── application.yaml                # Configuration
│   └── test/
│       └── java/com/example/scheduler/
│           └── SchedulerApplicationTests.java  # Unit tests
├── pom.xml                                      # Maven dependencies
└── README.md
```

## Technology Stack

- **Java**: 21
- **Spring Boot**: 4.0.3
- **Build Tool**: Maven
- **Virtual Threads**: Enabled for improved performance

## API Endpoints

### Trigger Manual Task
```
POST /api/tasks/trigger
```
Manually triggers a task execution and updates the last event.

**Example:**
```bash
curl -X POST http://localhost:8080/api/tasks/trigger
```

### Get Task Status
```
GET /api/tasks/status
```
Returns the current task status with the last event message and timestamp.

**Response:**
```json
{
  "message": "Scheduled task ran at 2026-03-10T12:34:56.789Z",
  "timestamp": 1234567890000
}
```

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6.0 or higher

### Build & Run

1. **Build the project:**
   ```bash
   ./mvnw clean package
   ```

2. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

3. **Verify the application is running:**
   ```bash
   curl http://localhost:8080/api/tasks/status
   ```

## Configuration

Edit `src/main/resources/application.yaml` to customize:

```yaml
spring:
  application:
    name: scheduler
  threads:
    virtual:
      enabled: true
```

### Customizing Scheduled Task Interval

In `TaskService.java`, modify the `@Scheduled` annotation:
```java
@Scheduled(fixedDelay = 5000)  // 5000ms = 5 seconds
```

## Features

- **Scheduled Execution**: Tasks run automatically at configured intervals
- **Manual Triggers**: REST endpoint to manually invoke tasks
- **Event Logging**: Tracks last event with timestamp
- **CORS Support**: Configured for frontend integration (port 4200)

## Development Notes

- The application uses Spring's `@EnableScheduling` annotation for task scheduling
- Virtual threads are enabled for better resource utilization
- All task events are logged to console and stored in memory
- CORS is configured to allow requests from `http://localhost:4200`

## Future Enhancements

- Persistent task history storage (database integration)
- Configurable scheduling intervals via API
- Task execution history and analytics
- Multiple task types and complex scheduling rules
- Authentication and authorization
