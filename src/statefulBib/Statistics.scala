package statefulBib

class Statistics(lstExercices: List[Exercice] = List()) {
  val listExercices : List[Exercice] = lstExercices
  
  def addExercice (exercice: Exercice): List[Exercice] = {
    if (!listExercices.exists(_.id == exercice.id)){
      return exercice :: listExercices
    }
    listExercices
  }
  
  def preTests(): List[Exercice] = {
    listExercices.map(e => {
      if (e.diffLevel >= 1 && e.diffLevel <= 3)
        e
      else if (e.diffLevel < 1)
        e.makeEasy()
      else if (e.diffLevel > 3)
        e.makeHard()
    }).asInstanceOf[List[Exercice]]
  }
  
  def getExercicesByDifficulty(diffLevel: Int): List[Exercice] = listExercices.filter(_.diffLevel == diffLevel)
  
  def exercicesSortedByDifficulty(): List[Exercice] = {
    val plusDifficile = getExercicesByDifficulty(3)
    plusDifficile.sorted
  }
  
  def listTopics(): List[String] = listExercices.map(_.topic)
}