<script>
  import Carousel from "svelte-carousel";
  import CarouselImage from "./components/Carousel/CarouselImage.svelte";
  import Navbar from "./components/Navbar/Navbar.svelte";
  //Arreglo temparal de peliculas
  // TEMPORAL
  let movieList = [
    {
      id: 1,
      rating: 5,
      title: "Interstellar",
      shortDescription: "Pelicula sobre un viaje a las estrellas",
      imgUrl:
        "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/rAiYTfKGqDCRIIqo664sY9XZIvQ.jpg",
    },
    {
      id: 2,
      rating: 1,
      title: "kill bill",
      shortDescription: "Una mujer buscando vanganza contra bill",
      imgUrl:
        "https://www.themoviedb.org/t/p/original/pcXvjjMOacxXJDqAaZQH26UKn1C.jpg",
    },
    {
      id: 3,
      rating: 3,
      title: "Pixels",
      shortDescription: "Unos aliens en forma de videojuegos atacan la tierra",
      imgUrl:
        "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/rCsIKy3bWPyrMg6urfOm5YR9uoz.jpg",
    },
    {
      id: 4,
      rating: 5,
      title: "Van Helsing",
      shortDescription: "Un cazador de vampiros",
      imgUrl:
        "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/d72ROyJqXQtw2OupW0l15eicRAF.jpg",
    },
    {
      id: 5,
      rating: 5,
      title: "Hell boy",
      shortDescription: "Un demonio que combate el crimen",
      imgUrl:
        "https://www.themoviedb.org/t/p/original/lsm1M5PvJYkg24TXtQKWLRHrtNF.jpg",
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
    {#each movieList as { id, title, shortDescription, rating, imgUrl }}
      <!-- TEMPORAL -->
      <CarouselImage {title} {shortDescription} {rating} {imgUrl} />
    {/each}
  </Carousel>
</main>
