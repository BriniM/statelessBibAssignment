package statefulBib

class Submission(s_text : String , s_grade : Double) extends Ordered[Submission] {
  val text : String = s_text
  val grade : Double = s_grade

  override def compare(that: Submission): Int = java.lang.Double.compare(grade, that.grade)

  override def toString: String = s"Text: ${text}\nGrade: ${grade}"
}