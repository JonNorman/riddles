package riddles

object Hats {

  sealed trait Hat
  case object Black extends Hat
  case object White extends Hat

  def runRiddle(prisoners: List[Hat],
                makeGuess: (List[Hat], List[Hat]) => Hat) =
    prisoners.foldLeft(List[Hat]()){
      (guesses, _) => guesses :+ makeGuess(prisoners.drop(guesses.size), guesses)
    }
}
