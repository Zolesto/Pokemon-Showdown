# Showdown (Android)

A lightweight Android app that wraps [pokemonshowdown.com](https://pokemonshowdown.com/) in a full-screen WebView.

## Install

1. Open the **Releases** page of this repo on your phone and download the latest `Showdown-v1.0.N.apk`.
2. Open it and allow installs from your browser when Android asks.

Every push to `main` builds a new APK and publishes it as a release. Builds share one signing key, so a new version installs over the old one.

## What it does

- Keeps Showdown pages (site, battle client, replays, login) inside the app; other links open in your browser.
- Saves teams, settings and login between sessions.
- Plays battle music and sounds; supports file pickers; the back button goes back a page.

## Change the start page

Edit `START_URL` in `app/src/main/java/com/zolesto/showdown/MainActivity.java`
(for example, `https://play.pokemonshowdown.com/` to open straight into the battle client).

Unofficial personal app; not affiliated with Pokémon Showdown.
