export DISPLAY=:0;
export KIOSK_URI='http://www.google.com';

chromium-browser \
  --kiosk --enable-fullscreen \
  --touch-events=enabled \
  --activate-on-launch \
  --noerrdialogs \
  --disable-pinch \
  --disable-features=OverscrollHistoryNavigation \
  --start-maximized \
  --disable-infobars \
  --disable-notifications \
  --disable-session-crashed-bubble \
  --no-first-run \
  --enable-offline-auto-reload \
  --autoplay-policy=no-user-gesture-required \
  --deny-permission-prompts \
  --disable-search-geolocation-disclosure \
  --simulate-outdated-no-au='Tue, 31 Dec 2099 23:59:59 GMT' \
  --disable-component-update \
  --allow-browser-signin=false \
  "${KIOSK_URI}"