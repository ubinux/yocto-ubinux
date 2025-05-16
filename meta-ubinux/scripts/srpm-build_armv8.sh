#!/bin/bash
recipes=(
  libevent
  swupdate
  restool
  openjdk-8
  giflib
  libiodbc
  pgpool2
  psqlodbc
  unixodbc
  libmemcached
  libubootenv
)

failed_recipes=()

for recipe in "${recipes[@]}"; do
  if ! bitbake "$recipe" -f -c deploy_archives; then
    echo "ERROR: Failed to deploy $recipe"
    failed_recipes+=("$recipe")
  fi
done

if [ ${#failed_recipes[@]} -ne 0 ]; then
  echo "armv8 Result: The following recipes failed to deploy:"
  for failed in "${failed_recipes[@]}"; do
    echo " - $failed"
  done
  exit 1
fi