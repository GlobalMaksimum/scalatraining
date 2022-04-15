package training

import java.util.Date
import scala.io.Source
import scala.util.Try
import scala.util.Success
import scala.util.Failure

object collectionexamples {

  case class Movie(
      id: Int,
      title: String,
      year: Option[Int],
      genres: List[String]
  )

  case class Rating(userId: Int, movieId: Int, rating: Double, ts: Date)

  def parseRating(line: String): Rating = line.split(',').toList match {
    case userId :: movieId :: rating :: ts :: Nil =>
      Rating(
        userId.toInt,
        movieId.toInt,
        rating.toDouble,
        new Date(ts.toLong * 1000)
      )
  }

  def parseMovie(line: String): Movie = {
    val splitted = line.split(",", 2)

    val id = splitted(0).toInt
    val remaining = splitted(1)
    val sp = remaining.lastIndexOf(",")
    val titleDirty = remaining.substring(0, sp)
    val title =
      if (titleDirty.startsWith("\"")) titleDirty.drop(1).init else titleDirty   // Filmin Adi

    val year = Try(
      title
        .substring(title.lastIndexOf("("), title.lastIndexOf(")"))
        .drop(1)
        .toInt
    ).toOption
    val genres = remaining.substring(sp + 1).split('|').toList
    Movie(id, title, year, genres)
  }

  def main(args: Array[String]): Unit = {
    val movieLines =
      Source.fromFile("data/movies.csv").getLines().toList.drop(1)
    val ratingLines =
      Source.fromFile("data/ratings.csv").getLines().toList.drop(1)

    val movies = movieLines.map(parseMovie)
    val movieMap = movies.map(m=> (m.id,m)).toMap
    val ratings = ratingLines.map(parseRating)
    val groupedRatings = ratings.groupBy(r => r.movieId)
    val averageRatings = groupedRatings.map { case (k,v) =>
      (k,v.map(_.rating).sum,v.length)
    }.toList.sortBy(_._2).reverse.take(10)
    val result = averageRatings.map(ar => (movieMap(ar._1).title,ar._2,ar._3))
    result.foreach(println)
  }

  private def bestYears(movies: List[Movie]) = {
    val years = movies.flatMap(_.year)
    val groupedYears =
      years.groupBy(i => i).map { case (k, v) => (k, v.length) }.toList
    groupedYears
      .sortBy(_._2)
      .reverse
      .foreach(println)
  }

  private def distinctGenres(movies: List[Movie]) = {
    val genres = movies.flatMap(_.genres)
    val countGenres = genres.groupBy(i => i)
    val grouped = countGenres.map { case (k, v) => (k, v.length) }.toList
    grouped.sortBy(_._2).reverse.foreach(println)
  }
}
