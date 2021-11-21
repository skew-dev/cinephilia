<script>
  export let title;
  export let shortDescription;
  export let rating;
</script>

<div class="CarouselImage">
  <div class="container">
    <div class="title">
      {title}
    </div>
    <div class="short-description">
      {shortDescription}
    </div>
    <div class="rating">{rating}</div>
  </div>
</div>

<style>
  .container {
    /* width: 100%; */
    background-color: aqua;
    padding: 5rem;
  }
</style>
