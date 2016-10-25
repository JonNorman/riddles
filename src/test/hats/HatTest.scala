package riddles

import org.scalatest.FlatSpec
import Hats._

class HatSpec extends FlatSpec {

  def strategy(visibleHats: List[Hat], guessesSoFar: List[Hat]): Hat = {
    ???
  }

  def check(hats: List[Hat], guesses: List[Hat]): Unit = {
    val correctAnswers: List[Hat] = (hats zip guesses) collect {
      case (hat, guess) if hat == guess => guess
    }

    val correct: Boolean = correctAnswers.size.toDouble / hats.size >= (hats.size.toDouble - 1) / hats.size
    assert(correct, s"Insufficiently accurate guess, <insert terrible consequence here>.\nGuesses: $guesses\nAnswer : $hats")
  }

  "The group" should "correctly guess an entirely white-hatted line" in {
    val hats = List.fill(10)(White)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess an entirely black-hatted line" in {
    val hats = List.fill(10)(Black)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess an alternating colour line #1" in {
    val hats = List(White, Black, White, Black, White, Black, White, Black, White, Black)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess an alternating colour line #2" in {
    val hats = List(Black, White, Black, White, Black, White, Black, White, Black, White)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess a majority black coloured line #1" in {
    val hats = List(White, White) ++ List.fill(8)(Black)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess a majority black coloured line #2" in {
    val hats = List(White, White, White, White) ++ List.fill(6)(Black)
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }

  it should "correctly guess a majority black coloured line #3" in {
    val hats = List.fill(9)(Black) :+ White
    val guesses = runRiddle(hats, strategy)
    check(hats, guesses)
  }
}
