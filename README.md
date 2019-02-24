# Demo

Sac demo system.

## Environment
1. Java version 10.0.2+
2. Apache Maven 3.5.2+
3. Node version 11.7.0+

## HOW-TO

> When in first time:
  1. Run
  ```bash
  npm install -g @Angular/cli
  ```
  2. Change path to /src/main/client
  3. Run 
  ```bash
  npm install
  ```

1. Run front end.

   ```bash
   ./run.sh front
   ```

2. Run back end.

   ```bash
   ./run.sh back
   ```

3. Build.

   ```bash
   # in /src/main/client
   npm run build
   ```

   All front end static files will be built in /src/main/resources/static.

> On Windows:
  1. Run back end.
  ```bash
  mvnw spring-boot:run -DskipTests=true
  ```

  2. Run front end.
  ```bash
  cd src/main/client
  npm run start
  ```