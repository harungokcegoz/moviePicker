// To write moods for select tab
const get_mood_url = "http://localhost:8080/getMoods";
const get_movies_url = "http://localhost:8080/getMovies";
const get_review_url = "http://localhost:8080/getReviews";
const add_review_url = "http://localhost:8080/review/add";
let foundMovie = [];
let arrayMoods = [];
let arrayReviews = [];
let arrayMovies = [];
var submitOption = document.getElementById("submit-option");
var sendReviewButton = document.getElementById("review-submit-option");
var reviewInput = document.getElementById("review-input");
var ratingInput = document.getElementById("rating-input");
var select = document.querySelector("select");
var randomNumber = 0;

getApi();

async function getApi() {
  //storing response
  const response = await fetch(get_mood_url);
  var dataMood = await response.json();
  const response1 = await fetch(get_movies_url);
  var dataMovie = await response1.json();
  const response2 = await fetch(get_review_url);
  var dataReview = await response2.json();

  if (response || response1 || response2) {
    hideloader();
  }
  saveData(dataMood, dataMovie, dataReview);

  dropdownList(arrayMoods);
  submitOption.addEventListener("click", handleSubmit);
  sendReviewButton.addEventListener("click", function (e) {
    e.preventDefault();
    let data = {};

    data["id"] = 26;
    data["review"] = reviewInput.value;
    data["rating"] = ratingInput.value;
    data["movie"] = foundMovie[randomNumber];

    postNewReview(data);
  });
}

function hideloader() {}

function saveData(dataMood, dataMovie, dataReview) {
  for (let r of dataMovie) {
    arrayMovies.push(r);
  }
  for (let r of dataMood) {
    arrayMoods.push(r);
  }
  for (let r of dataReview) {
    arrayReviews.push(r);
  }
}

function dropdownList(arrayMoods) {
  var select = document.querySelector("select");
  for (let r of arrayMoods) {
    var opt = document.createElement("option");
    opt.value = r.moodId;
    opt.innerHTML = r.moodName;
    select.appendChild(opt);
  }
}

function handleSubmit() {
  while (foundMovie.length) {
    foundMovie.pop();
  }
  var selected = select.options[select.selectedIndex].value;
  findTheMovie(selected);
}

function findTheMovie(userValue) {
  for (let i = 0; i < arrayMovies.length; i++) {
    if (arrayMovies[i].mood.moodId == userValue) {
      foundMovie.push(arrayMovies[i]);
    }
  }

  progressbar();
  showRandomRelevantMovie();
}

function showRandomRelevantMovie() {
  randomNumber = Math.floor(Math.random() * foundMovie.length);

  var pickedMovie = foundMovie[randomNumber];
  var pickedMovieId = pickedMovie.id;
  var movieImage = document.querySelector("img");
  movieImage.src = pickedMovie.image;
  var movieName = document.getElementsByClassName(
    "movie-list-movies-content-header"
  );
  movieName[0].innerHTML =
    pickedMovie.name + " (" + pickedMovie.releaseYear + ")";
  var movieCategory = document.getElementsByClassName(
    "movie-list-movies-content-text-small"
  );
  movieCategory[0].innerHTML = "<b>Category:</b> " + pickedMovie.category;
  var movieDescription = document.getElementsByClassName(
    "movie-list-movies-small-description"
  );
  movieDescription[0].innerHTML =
    "<b>Description:</b> " + pickedMovie.description;
  var movieMood = document.getElementsByClassName(
    "movie-list-movies-content-text-small-mood"
  );
  movieMood[0].innerHTML = "<b>Mood:</b> '" + pickedMovie.mood.moodName + "'";

  var movieRating = document.getElementsByClassName(
    "movie-list-movies-content-text-small-rating"
  );

  var movieReview = document.getElementsByClassName("review");
  for (let i = 0; i < arrayReviews.length; i++) {
    if (arrayReviews[i].movie.id == pickedMovieId) {
      movieReview[0].innerHTML =
        "</br>REVIEWS " + ":</br></br> " + arrayReviews[i].review;
      movieRating[0].innerHTML =
        "<b>IMDb Rating:</b> " + arrayReviews[i].rating;
    }
  }
}

function progressbar() {
  var element = document.getElementById("myprogressBar");
  var element1 = document.getElementById("bar-text");
  element.style.visibility = "visible";
  element1.style.visibility = "visible";
  var width = 1;
  var identity = setInterval(scene);
  function scene() {
    if (width >= 100) {
      clearInterval(identity);
    } else {
      width++;
      element.style.width = width + "%";
      element.innerHTML = width * 1 + "%";
    }
  }
}

async function postNewReview(data) {
  const response = await fetch(add_review_url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  alert("The review is added!");
  await response.json();
}
