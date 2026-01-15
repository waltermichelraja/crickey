set -e
APP_BIN="./app/build/install/app/bin/app"
if [ "$1" = "--build-run" ]; then
    ./gradlew :app:installDist 
    "$APP_BIN"
elif [ "$1" = "--build" ]; then 
    ./gradlew :app:installDist
else 
    "$APP_BIN"
fi
