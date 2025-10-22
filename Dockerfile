FROM php:8.2-apache

# Instalar PostgreSQL extension
RUN apt-get update && apt-get install -y libpq-dev && docker-php-ext-install pdo pdo_pgsql

# Copiar el frontend al directorio correcto de Apache
COPY frontend/ /var/www/html/

# Dar permisos
RUN chown -R www-data:www-data /var/www/html/

EXPOSE 80