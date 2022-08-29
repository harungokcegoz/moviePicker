const get_movie_url = "http://localhost:8080/getMovie/";
let arrayTopMovies = [];
var prvBut = document.getElementById("pre-btn");
var nxtBut = document.getElementById("nxt-btn");
var movieImage = document.querySelector("img");
var movieName = document.getElementsByClassName(
  "movie-list-movies-content-header"
);
var movieDescription = document.getElementsByClassName(
  "movie-list-movies-description"
);
var movieNumber = 0;

getApi();

async function getApi() {
  for (let i = 1; i <= 10; i++) {
    const response = await fetch(get_movie_url + i);
    var movie = await response.json();
    arrayTopMovies.push(movie);
  }
  console.log(arrayTopMovies);
  printMovieCards();
  prvBut.addEventListener("click", previousMovie);
  nxtBut.addEventListener("click", nextMovie);
}

function previousMovie() {
  if (movieNumber == 0) {
    movieName[0].innerHTML =
      arrayTopMovies[movieNumber].name +
      " (" +
      arrayTopMovies[movieNumber].releaseYear +
      ")";
    movieImage.src = arrayTopMovies[movieNumber].image;
    movieDescription[0].innerHTML =
      "<br><br>" + arrayTopMovies[movieNumber].description;
  } else {
    movieNumber--;
    movieName[0].innerHTML =
      arrayTopMovies[movieNumber].name +
      " (" +
      arrayTopMovies[movieNumber].releaseYear +
      ")";
    movieImage.src = arrayTopMovies[movieNumber].image;
    movieDescription[0].innerHTML =
      "<br><br>" + arrayTopMovies[movieNumber].description;
  }
}
function nextMovie() {
  if (movieNumber >= 9) {
    movieNumber = 0;
    movieName[0].innerHTML =
      arrayTopMovies[movieNumber].name +
      " (" +
      arrayTopMovies[movieNumber].releaseYear +
      ")";
    movieImage.src = arrayTopMovies[movieNumber].image;
    movieDescription[0].innerHTML =
      "<br><br>" + arrayTopMovies[movieNumber].description;
  } else {
    movieNumber++;
    movieName[0].innerHTML =
      arrayTopMovies[movieNumber].name +
      " (" +
      arrayTopMovies[movieNumber].releaseYear +
      ")";
    movieImage.src = arrayTopMovies[movieNumber].image;
    movieDescription[0].innerHTML =
      "<br><br>" + arrayTopMovies[movieNumber].description;
  }
}

function printMovieCards() {
  movieName[0].innerHTML =
    arrayTopMovies[movieNumber].name +
    " (" +
    arrayTopMovies[movieNumber].releaseYear +
    ")";
  movieImage.src = arrayTopMovies[movieNumber].image;
  movieDescription[movieNumber].innerHTML =
    "<br><br>" + arrayTopMovies[movieNumber].description;
}
