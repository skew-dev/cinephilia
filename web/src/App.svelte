<script>
  import Carousel from "svelte-carousel";
  import CarouselImage from "./components/CarouselImage.svelte";
  import MovieGrid from "./components/MovieGrid.svelte";
  import Navbar from "./components/Navbar.svelte";

  //Arreglo temparal de peliculas
  let movieList = [
    {
      id: 1,
      rating: 5,
      title: "Interstellar",
      shortDescription: "Pelicula sobre un viaje a las estrellas",
    },
    {
      id: 2,
      rating: 5,
      title: "kill bill",
      shortDescription: "Una mujer buscando vanganza contra bill",
    },
    {
      id: 3,
      rating: 5,
      title: "Pixels",
      shortDescription: "Unos aliens en forma de videojuegos atacan la tierra",
    },
    {
      id: 4,
      rating: 5,
      title: "Van Helsing",
      shortDescription: "Un cazador de vampiros",
    },
    {
      id: 5,
      rating: 5,
      title: "Hell boy",
      shortDescription: "Un demonio que combate el crimen",
    },
  ];
</script>

<main>
  <Navbar />
  <Carousel
    autoplay
    autoplayDuration={5000}
    autoplayProgressVisible
    pauseOnFocus
  >
    {#each movieList as { id, title, shortDescription, rating }}
      <CarouselImage {title} {shortDescription} {rating} />
    {/each}
  </Carousel>

  <MovieGrid {movieList} />
</main>

<style>
  main {
    text-align: center;
    padding: 1em;
    max-width: 240px;
    margin: 0 auto;
  }

  @media (min-width: 640px) {
    main {
      max-width: none;
    }
  }
</style>
