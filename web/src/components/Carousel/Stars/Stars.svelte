<script>
  export let rating;

  import EmptyStar from "./EmptyStar.svelte";
  import FilledStar from "./FilledStar.svelte";
</script>

<div class="content">
  {#if rating == 0}
    <EmptyStar /><EmptyStar /><EmptyStar /><EmptyStar /><EmptyStar />
  {:else if rating == 1}
    <FilledStar /><EmptyStar /><EmptyStar /><EmptyStar /><EmptyStar />
  {:else if rating == 2}
    <FilledStar /><FilledStar /><EmptyStar /><EmptyStar /><EmptyStar />
  {:else if rating == 3}
    <FilledStar /><FilledStar /><FilledStar /><EmptyStar /><EmptyStar />
  {:else if rating == 4}
    <FilledStar /><FilledStar /><FilledStar /><FilledStar /><EmptyStar />
  {:else if rating == 5}
    <FilledStar /><FilledStar /><FilledStar /><FilledStar /><FilledStar />
  {/if}
</div>

<style>
</style>
