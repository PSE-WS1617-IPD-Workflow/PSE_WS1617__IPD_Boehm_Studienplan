import java.io.File

import scala.io.Source

/**
  * This is a small, quickly and dirtily hacked Scala script which extracts a class index out of a "..\docs.tex" file.
  * Try at home at own risk.
  *
  * @author Daniel Jungkind
  */
object ClassIndex extends App {
  assert (System.getProperty("user.dir") endsWith "Classindex")
  val docstex = new File(System.getProperty("user.dir") + "\\..\\docs.tex")
  assert(docstex.exists)


  val pattern = "\\\\label\\{texdoclet:([^\\}]*)\\}".r

  val text = Source.fromFile(docstex).mkString
  val labels = pattern.findAllMatchIn(text).map{_.group(1)}.toList

  def lastIdent(s: String) = s.reverse.takeWhile('.'!=).reverse  //org.bla.whatever.abc => abc
  def getPackage(s: String) = s contains "." match {
    case true => s.reverse.dropWhile('.'!=).tail.reverse
    case false => ""
  }
  def getShortPackage(s: String) = getPackage(s.stripPrefix("edu.kit.informatik.studyplan."))

  def duplicates[T, B](l: List[T], f: T => B) = l.groupBy(f).collect { case (x, ds) if ds.size > 1  => ds }.flatten
  def singles[T, B](l: List[T], f: T => B)    = l.groupBy(f).collect { case (x, ss) if ss.size == 1 => ss.head }

  val (classes, packages) = labels.partition(s => lastIdent(s).head.isUpper)

  val LaTeX = true
  def formatDuplicateEntry(fullName: String) =
    if (LaTeX)
      s"\\hyperref[texdoclet:$fullName]{${lastIdent(fullName)}} \\textit{(${getShortPackage(fullName)})} \\newline"
    else
      s"${lastIdent(fullName)} (${getShortPackage(fullName)})"
  def formatSingleEntry(fullName: String) =
    if (LaTeX)
      s"\\hyperref[texdoclet:$fullName]{${lastIdent(fullName)}}\\newline"
    else
      s"${lastIdent(fullName)}"

  val serverPacks = packages.filter { _ contains "studyplan.server" } :+ "org.hibernate"
  val clientPacks = packages.filter { _ contains "studyplan.client" } :+ "org.backbone"

  val serverClasses = classes filter {serverPacks contains getPackage(_)}
  val clientClasses = classes filter {clientPacks contains getPackage(_)}

  val serverDisambig = (
      duplicates(serverClasses, lastIdent).map(s => (s, formatDuplicateEntry(s))) ++
      singles(serverClasses, lastIdent).map(s => (s, formatSingleEntry(s)))
    ).toList

  val clientDisambig = (
      duplicates(clientClasses, lastIdent).map(s => (s, formatDuplicateEntry(s))) ++
      singles(clientClasses, lastIdent).map(s => (s, formatSingleEntry(s)))
    ).toList



  val serverClassesOutput = serverDisambig.
    sortBy{case (s, _) => lastIdent(s)}.
    map{_._2}
  val clientClassesOutput = clientDisambig.
    sortBy{case (s, _) => lastIdent(s)}.
    map{_._2}

  println("% auto-generated by classindex.scala")
  println("\\subsection{Client-Klassen} \\nopagebreak")
  println("\\begin{multicols}{2}")
    clientClassesOutput foreach println
  println("\\end{multicols}")
  println
  println
  println("\\subsection{Server-Klassen} \\nopagebreak")
  println("\\begin{multicols}{2}")
    serverClassesOutput foreach println
  println("\\end{multicols}")
  //packages foreach println

}