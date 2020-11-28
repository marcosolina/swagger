#!/bin/bash


SERVICE_FOLDER=/opt/swagger/
SERVICE_JAR=${SERVICE_FOLDER}swaggertests.jar
SERVICE_NOHUP=${SERVICE_FOLDER}swagger.log
SERVICE_PID_FILE=${SERVICE_FOLDER}swagger.pid

case "$1" in
start)
   cd $COVID_FOLDER
   nohup java -jar $SERVICE_JAR >> $SERVICE_NOHUP 2>&1&
   echo $!>$SERVICE_PID_FILE
   chmod 775 $SERVICE_PID_FILE
   ;;
stop)
   kill `cat $SERVICE_PID_FILE`
   rm $SERVICE_PID_FILE
   ;;
restart)
   $0 stop
   $0 start
   ;;
status)
   if [ -e $SERVICE_PID_FILE ]; then
      echo Swagger is running, pid=cat $SERVICE_PID_FILE
   else
      echo Swagger is NOT running
      exit 1
   fi
   ;;
*)
   echo "Usage: $0 {start|stop|status|restart}"
esac

exit 0
