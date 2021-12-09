<script>
  import Carousel from "svelte-carousel";
  import CarouselImage from "./components/CarouselImage.svelte";
  import Navbar from "./components/Navbar.svelte";
  //Arreglo temparal de peliculas
  let movieList = [
    {
      id: 1,
      rating: 5,
      title: "Interstellar",
      shortDescription: "Pelicula sobre un viaje a las estrellas",
      imgUrl:
        "https://www.themoviedb.org/t/p/original/wP0X5iQrlt7ojPmWouYPfy8AQtx.jpg",
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
      <!-- TEMPORAL -->
      <CarouselImage {title} {shortDescription} {rating} />
    {/each}
  </Carousel>
</main>
