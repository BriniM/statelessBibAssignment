package statefulBib

object App {
  def main(args: Array[String]): Unit = {
    val subs1 = List(new Submission("10", 10),
      new Submission("10", 8))

    val subs2 = List(new Submission("20", 11),
      new Submission("21", 9.5))

    val subs3 = List(new Submission("30", 12),
      new Submission("31", 13))

    val exercice1 = new Exercice(0, "A", 4, subs1)
    val exercice2 = new Exercice(1, "B", 0, subs2)
    val exercice3 = new Exercice(2, "C", 1, subs3)

    val stats1 = new Statistics(List(exercice1, exercice2, exercice3))
    val stats2 = new Statistics(stats1.preTests())

    println("Les exercices avec la difficulté easy: ")
    stats2.getExercicesByDifficulty(1).foreach(println(_))

    println("Les exercices trié selon les grades et la difficulté: ")
    stats2.exercicesSortedByDifficulty().foreach(println(_))

    println("Topics des exerices: ")
    stats2.listTopics().foreach(println(_))
  }
}
