# Midi-Instruments

A library of Overtone MIDI instrument patches

## Installation

See the Overtone project for documentation on Clojure, Overtone, and JACK: https://github.com/overtone/overtone 

## Usage

1. Run one of the JACK start scripts.
2. Run: lein repl
3. (use 'overtone.live) ; Should import Overtone and connect to Jack on Linux or mac, see the Overtone project for better intructions.
4. (use 'midi-instruments.foo) ; Where "foo" is the desired instrument name.
5. Send MIDI messages to any channel in JACK, and listen to the playback through JACK.
6. When done, run (midi-player-stop foo-player). This should make the instrument stop listening for MIDI messages. Make sure that all new instruments follow this naming convention for their player object name bindings: "foo-player", where "foo" is the instrument name.

## License

Copyright © 2018 Cary Willard

Distributed under the MIT License
