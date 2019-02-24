#!/bin/bash
mode=$1
echo "Trying to run server in mode: $mode"
if [ $mode == "back" ]
then
  ./mvnw spring-boot:run -DskipTests=true
elif [ $mode == "front" ]
then
  cd src/main/client
  npm run start
else
  echo "wrong input!"
fi

# ./mvnw spring-boot:run -DskipTests=true
