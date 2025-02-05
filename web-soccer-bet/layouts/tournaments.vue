<template>
  <div>
    <header class="shadow-sm bg-white">
      <nav class="container mx-auto p-4">
        <NuxtLink to="/" class="font-bold">Soccer Bet</NuxtLink>
      </nav>
    </header>

    <!-- output the page content -->
    <div  class="container mx-auto p-4">
      <slot />
    </div>

    <footer class="container mx-auto p-4 flex justify-between border-t-2">
      <nav>
        <ul class="flex  gap-3">
          <li>
            <NuxtLink to="/">Home</NuxtLink>
          </li>
          <li>
            <NuxtLink to="/tournaments/" class="btn-active">Tournaments</NuxtLink>
          </li>
        </ul>
      </nav>
    </footer>
  </div>
</template>

<script setup></script>

<style scoped></style>
