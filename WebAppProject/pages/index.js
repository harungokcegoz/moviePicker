// To write moods for select tab
const api_mood_url = "http://localhost:8080/api/moods/get";
const api_movies_url = "http://localhost:8080/api/movies/get";
const api_review_url = "http://localhost:8080/api/review/post";
let foundMovie = [];
let arrayMoods = [];
let arrayMovies = [];
var submitOption = document.getElementById("submit-option");
var sendReviewButton = document.getElementById("review-submit-option");
var reviewInput = document.getElementById("review-input");
var select = document.querySelector("select");
var randomNumber = 0;
// const post = {
//   title: "User Review",
//   body: reviewInput.value,
//   reviewId: 26,
// };

getApi();

async function getApi() {
  //storing response
  const response = await fetch(api_mood_url);
  var dataMood = await response.json();
  const response1 = await fetch(api_movies_url);
  var dataMovie = await response1.json();

  if (response || response1) {
    hideloader();
  }
  saveData(dataMood, dataMovie);
  dropdownList(arrayMoods);
  submitOption.addEventListener("click", handleSubmit);
  sendReviewButton.addEventListener("click", sendReview);
}

function hideloader() {}

function saveData(dataMood, dataMovie) {
  for (let r of dataMovie) {
    arrayMovies.push(r);
  }
  for (let r of dataMood) {
    arrayMoods.push(r);
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
  console.log(foundMovie);
  for (let i = 0; i < arrayMovies.length; i++) {
    if (arrayMovies[i].mood.moodId == userValue) {
      foundMovie.push(arrayMovies[i]);
    }
  }
  progressbar();
  showRandomRelevantMovie();
}

function showRandomRelevantMovie() {
  console.log(foundMovie[randomNumber]);
  console.log(randomNumber);
  randomNumber = Math.floor(Math.random() * foundMovie.length);
  console.log(randomNumber);
  var pickedMovie = foundMovie[randomNumber];
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
  movieRating[0].innerHTML =
    "<b>IMDb Rating:</b> " + pickedMovie.review[0].rating;
  var movieReview = document.getElementsByClassName("review");
  for (let i = 0; i < pickedMovie.review.length; i++) {
    movieReview[0].innerHTML =
      "</br>REVIEW " + (i + 1) + ":</br></br> " + pickedMovie.review[i].review;
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
// function sendReview() {
//   var element = document.getElementById("review-form");
//   element.addEventListener("click", function (e) {
//     e.preventDefault();

//     const formData = new FormData(this);
//     fetch(api_review_url, {
//       method: "POST",
//       body: formData,
//     })
//       .then(function (response) {
//         return response.text();
//       })
//       .then(function (text) {
//         console.log(text);
//       })
//       .catch(function (error) {
//         console.error(error);
//       });
//   });
// }
// const newPost = (post) => {
//   const options = {
//     method: "POST",
//     body: JSON.stringify(post),
//     headers: new Headers({
//       "Contect-Type": "application/json",
//     }),
//   };
//   return fetch("http://localhost:8080/api/review/post", options)
//     .then((res) => res.json())
//     .then((res) => console.log(res))
//     .catch((error) => console.error("Error: " + error));
// };
// Sending and receiving data in JSON format using POST method
//

function sendReview() {
  console.log("Send Review");
  var xhr = new XMLHttpRequest();
  var url = "http://localhost:8080/api/review/post";
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var json = JSON.parse(xhr.responseText);
      console.log(json);
    }
  };
  console.log(randomNumber);
  console.log(foundMovie[randomNumber]);
  var data = JSON.stringify({
    review: reviewInput.value,
    movieId: foundMovie[randomNumber].id,
  });

  console.log(data);
  xhr.send(data);
}
