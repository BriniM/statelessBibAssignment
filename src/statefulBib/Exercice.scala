package statefulBib

// Il est possible de remplacer le type de e_diff par un Enum: Difficulty.EASY, Difficulty.MEDIUM
// Difficulty.HARD...
class Exercice(e_id : Int , e_topic : String , e_diff : Int, e_subs: List[Submission] = List())
  extends Ordered[Exercice] {

  val id : Int = e_id
  val topic : String = e_topic
  val diffLevel : Int = e_diff
  val submissions : List[Submission] = e_subs

  override def compare(that: Exercice): Int = {
    val thisAvg = submissions.map(_.grade).sum / submissions.length
    val thatAvg = that.submissions.map(_.grade).sum / that.submissions.length

    java.lang.Double.compare(thisAvg, thatAvg)
  }

  override def toString: String = f"ID: ${id}\nTopic: ${topic}\nDifficulté: ${diffLevel}\n" + submissions

  def makeHard(): Exercice = new Exercice(id, topic, 3, submissions)
  def makeMedium(): Exercice = new Exercice(id, topic, 2, submissions)
  def makeEasy(): Exercice = new Exercice(id, topic, 1, submissions)
  def addSubmission(sub : Submission): List[Submission] = sub :: submissions
}