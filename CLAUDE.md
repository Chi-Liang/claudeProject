# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Before doing anything

Before taking any action on a request, check whether an available skill already covers it (`ls ~/.claude/skills .claude/skills`). If one matches, follow that skill instead of improvising.

## Project overview

This repo contains a single Spring Boot module, `demo/`, at the repo root. It's a small learning/demo project — a `HelloController` REST endpoint plus a static HTML form page, no database or test suite yet.

- Java 21, Spring Boot 4.1.0 (via `spring-boot-starter-parent`), Maven build (`demo/pom.xml`).
- Only dependency: `spring-boot-starter-web`.
- Entry point: `demo/src/main/java/com/example/demo/DemoApplication.java`.
- Server runs on port 8080 (`demo/src/main/resources/application.yml`).

## Commands

All commands are run from the `demo/` directory (that's where `pom.xml` lives), using the Maven wrapper if present, otherwise `mvn`:

```
cd demo
./mvnw spring-boot:run       # run the app locally (http://localhost:8080)
./mvnw clean package          # build the jar
./mvnw test                   # run tests (none exist yet)
./mvnw test -Dtest=ClassName#methodName   # run a single test once tests are added
```

## Architecture

- `com.example.demo.HelloController` — the only controller. Exposes:
  - `GET /hi` — returns a plain greeting string.
  - `GET /image` — streams `a.png` from the classpath (`src/main/resources/a.png`) as `image/png`.
- `src/main/resources/static/a.html` — a standalone static form page (name input, radio options, submit button that shows a JS `alert`). Not wired to any backend endpoint; served as-is by Spring Boot's static resource handling.
- No service/repository layers, no persistence, no security config — everything currently lives in the one controller class.

## Claude Code tooling in this repo

- `.claude/commands/deploy.md` defines a `/deploy` command that pushes this repo to `https://github.com/Chi-Liang/claudeProject.git`. It stages only source files (`demo/src/`, `demo/pom.xml`, `.gitignore`, `.claude/commands/`) — never `target/`, `.idea/`, `*.iml`, or `.claude/settings.local.json` — and always commits and pushes as a single combined command, asking the user for the commit message first.
- `.claude/skills/commit-helper/SKILL.md` generates a commit message from `git diff HEAD` on request.
- `.claude/hooks/` contains small Java programs (`PreToolUse`, `PostToolUse`, `Notification`) that Spring/Claude Code hook events invoke via `java -cp .claude/hooks <ClassName>`; each just appends the event's stdin payload to a log file (`preToolUse.log`, `postToolUse.log`, `notification.log`) in the same directory. A `UserPromptSubmit` hook additionally reminds Claude to check for relevant skills before responding.
