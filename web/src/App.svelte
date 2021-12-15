<script>
  import Carousel from "svelte-carousel";
  import CarouselImage from "./components/Carousel/CarouselImage.svelte";
  import Navbar from "./components/Navbar/Navbar.svelte";
  import MovieGrid from "./components/MovieGrid.svelte";
  import Movie from "./components/Movie.svelte";
  import { getAllMovies, getMovie } from "./api/cinephilia";
  import { onMount } from "svelte";

  let movie;
  let movies;

  async function populateMovies() {
    movies = await getAllMovies();
    console.log(movies);
  }

  async function populateMovieinfo(id) {
    movie = await getMovie(id);
    console.log(movie);
  }

  async function hashchange() {
    // the poor man's router! stolen
    const path = window.location.pathname;
    console.log(path)

    if (path.startsWith("/movie")) {
      const id = path.slice(7);
      console.log(id)
      await populateMovieinfo(id)
    } else {
      await populateMovies();
    }
  }

  onMount(hashchange);
</script>

<main>
  <Navbar />
  {#if movie}
  <Movie {movie} />
  {:else if movies}
    <Carousel
      autoplay
      autoplayDuration={5000}
      autoplayProgressVisible
      pauseOnFocus
    >
      {#each movies as { title, overview, poster_path, id }}
        <!-- TEMPORAL -->
        <CarouselImage {title} {overview} rating="5" {poster_path} />
      {/each}
    </Carousel>
    <MovieGrid {movies} />
  {/if}
</main>
