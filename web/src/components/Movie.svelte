<script>
  import { onMount } from "svelte";
  import { getMovieReviews } from "../api/cinephilia";
  export let movie;
  let reviews;

  async function populateReviews() {
    console.log(movie.id);
    reviews = await getMovieReviews(movie.id);
    console.log(typeof reviews);
  }

  onMount(populateReviews);

  let title = movie.title;
  let rating = movie.rating;
  let overview = movie.overview;
  let poster_path = movie.poster_path;
  let date = new Date(movie.created_at);
  let release_date = movie.release_date;
  let id = movie.id;
</script>

<div class="container">
  <div class="card-content" />
  <div class="">
    <figure class="image is-5by3">
      <img src={poster_path} alt={title} />
    </figure>
  </div>
  <div class="card-content">
    <div class="media">
      <div class="media-content">
        <p class="title is-4">{title}</p>
        <p class="subtitle is-6">{release_date}</p>
      </div>
    </div>

    <div class="content">
      {overview}
      <br />
      <time class="subtitle is-6" datetime="2016-1-1"
        >{date.toLocaleDateString("en-US")}</time
      >
    </div>
  </div>
  <p class="title">Reviews</p>
  <div class="cardContainer">
    {#if reviews}
      {#each reviews as review}
        <div class="card ">
          <div class="card-content">
            <div class="media">
              <div class="media-left">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  height="40px"
                  viewBox="0 0 24 24"
                  width="40px"
                  fill="#cbf6e9"
                  ><path d="M0 0h24v24H0V0z" fill="none" /><path
                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zM7.07 18.28c.43-.9 3.05-1.78 4.93-1.78s4.51.88 4.93 1.78C15.57 19.36 13.86 20 12 20s-3.57-.64-4.93-1.72zm11.29-1.45c-1.43-1.74-4.9-2.33-6.36-2.33s-4.93.59-6.36 2.33C4.62 15.49 4 13.82 4 12c0-4.41 3.59-8 8-8s8 3.59 8 8c0 1.82-.62 3.49-1.64 4.83zM12 6c-1.94 0-3.5 1.56-3.5 3.5S10.06 13 12 13s3.5-1.56 3.5-3.5S13.94 6 12 6zm0 5c-.83 0-1.5-.67-1.5-1.5S11.17 8 12 8s1.5.67 1.5 1.5S12.83 11 12 11z"
                  /></svg
                >
              </div>
              <div class="media-content">
                <p class="title is-4 has-text-white">
                  @{review.author.username}
                </p>
              </div>
            </div>

            <div class="content">
              {review.content}
            </div>
          </div>
        </div>
      {/each}
    {/if}
  </div>
</div>

<style>
  .card {
    background-color: #00d192;
    box-shadow: 3px 3px #81808069;
    padding-left: 0rem;
    color: #cbf6e9;
  }
  .cardContainer {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    width: 100%;
    gap: 10px;
  }
</style>
