<script>
  import Carousel from "svelte-carousel";
  import CarouselImage from "./components/Carousel/CarouselImage.svelte";
  import Navbar from "./components/Navbar/Navbar.svelte";
  import MovieGrid from "./components/MovieGrid.svelte";
  import { getAllMovies } from "./api/cinephilia";
  import { onMount } from "svelte";

  let movies;
  onMount(async () => {
    movies = await getAllMovies();
    console.log(movies);
  });
</script>

<main>
  <Navbar />
  {#if movies}
    <Carousel
      autoplay
      autoplayDuration={5000}
      autoplayProgressVisible
      pauseOnFocus
    >
      {#each movies as { title, overview, poster_path }}
        <!-- TEMPORAL -->
        <CarouselImage {title} {overview} rating="5" {poster_path} />
      {/each}
    </Carousel>
    <MovieGrid {movies} />
  {/if}
</main>
