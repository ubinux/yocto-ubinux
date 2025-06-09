#!/bin/bash
recipes=(
  lib32-jssocket
  lib32-libjs-jquery-cookie
  lib32-libjs-jquery-custom-scrollbar
  lib32-libjs-jquery-dropkick
  lib32-libjs-jquery-globalize
  lib32-libjs-jquery-icheck
  lib32-libjs-jquery-mousewheel
  lib32-libjs-jquery-ui
  lib32-smarty
  lib32-apcupsd
)

failed_recipes=()

for recipe in "${recipes[@]}"; do
  if ! bitbake "$recipe" -f -c deploy_archives; then
    echo "ERROR: Failed to deploy $recipe"
    failed_recipes+=("$recipe")
  fi
done

if [ ${#failed_recipes[@]} -ne 0 ]; then
  echo "lib32-x86 Result: The following recipes failed to deploy:"
  for failed in "${failed_recipes[@]}"; do
    echo " - $failed"
  done
  exit 1
fi
