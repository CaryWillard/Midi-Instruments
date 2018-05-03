(ns midi-instruments.flute
  (:use [overtone.core]))

(definst flute
  [note 61 amp 0.3 gate 1]
  (let [freq (midicps note)
        snd
          (+
            (* 0.5
              (rlpf
                (lf-tri freq)
                4000 2))
            (* 0.5
              (sin-osc freq))
            (* 0.4 0.5
              (rlpf
                (lf-tri (* freq 2))
                4000 2))
            (* 0.3 0.5
              (sin-osc (* freq 3))))
        env (env-gen (adsr 0.3 0.07 0.8 0.2) gate :action FREE)]
    (out 0 (* amp env snd))
    (out 1 (* amp env snd))))

; Registers the instrument to receive MIDI messages
(def flute-player (midi-poly-player flute 1))

; Call this to unregister the instrument
; (midi-player-stop flute-player)

