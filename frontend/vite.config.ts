import { defineConfig } from 'vite';

export default defineConfig({
  root: '.', // Directorio raíz del proyecto
  base: './', // Base relativa para despliegues
  build: {
    outDir: 'dist', // Carpeta de salida para producción
  },
  server: {
    port: 3000, // Puerto del servidor de desarrollo
  },
});