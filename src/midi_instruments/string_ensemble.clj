(ns midi-instruments.string-ensemble
  (:use [overtone.core]))

(definst string-ensemble
  [note 60 amp 1 gate 1]
  (let [freq (midicps note)
        vib #(add-cents % (* 1 (lf-tri:kr 5)))
        snd 
          (rlpf
            (+
              (* 1
                (lf-tri freq ))
              (* 0.7
                (pulse freq
                  (+ 0.4 (* 0.2 (lf-tri 3)))))
              (* 0.05 (white-noise)))
            8000
            1.1)
        env (env-gen (adsr 0.5 0.7 0.6 0.4) gate :action FREE)]
    (* amp env snd)))

(def strings-player (midi-poly-player string-ensemble))

;(midi-player-stop strings-player)

