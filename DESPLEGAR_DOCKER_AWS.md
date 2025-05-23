# 🚀 Despliegue de Microservicio Java + PostgreSQL en AWS con Docker

Guía paso a paso para construir, subir y desplegar tu microservicio en Amazon EC2 usando Docker y Docker Compose.

---

## 1️⃣ Construir y subir la imagen Docker

1. **Ajusta la imagen en tu `docker-compose.yml`:**
   ```yaml
   #En app
   #Anterior build: .
   #Cambiar build por image ya que es la que traeremos desde la nube de docker hub.
   image: rodamigo95/demomicroservices:latest
   ```

2. **Genera el `.jar` del servicio:**
   ```sh
   ./mvnw clean package -DskipTests
   ```

3. **Construye la imagen Docker:**
   ```sh
   docker build -t rodamigo95/demomicroservices:latest -f dockerfile .
   ```

4. **Haz login en Docker Hub:**
   ```sh
   docker login
   ```

5. **Sube la imagen a Docker Hub:**
   ```sh
   docker push rodamigo95/demomicroservices:latest
   ```

6. **Verifica la imagen en [Docker Hub](https://hub.docker.com).**

---

## 2️⃣ Configurar el servidor Amazon EC2

1. **Crea una instancia EC2**  
   - Distro: Amazon Linux 2023  
   - Tipo: t2.micro (10GB SSD)
   - Configura grupo de seguridad:  
     - `80` (HTTP), `8080` (App), `22` (SSH), `5432` (PostgreSQL)  
     - Todos en `0.0.0.0/0` (anywhere)
   - Asigna una IP elástica.

2. **Conéctate por SSH** usando tu llave (ppk o pem).

---

## 3️⃣ Instalar Docker y Docker Compose en EC2

```sh
sudo yum update -y
sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -a -G docker ec2-user
# Cierra sesión y vuelve a entrar para aplicar el grupo docker

# Instala Docker Compose
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-linux-$(uname -m) -o /usr/bin/docker-compose
sudo chmod 755 /usr/bin/docker-compose
docker-compose --version
```

---

## 4️⃣ Transferir y ejecutar Docker Compose

1. **Transfiere tu archivo `docker-compose.yml`**  
   Usa WinSCP, FileZilla o `scp` para copiar el archivo a tu instancia EC2.

2. **Verifica Docker:**
   ```sh
   docker ps -a
   ```

3. **Descarga la imagen desde Docker Hub (opcional):**
   ```sh
   docker pull rodamigo95/demomicroservices:latest
   ```

4. **Levanta los servicios (app + db):**
   ```sh
   docker-compose up -d
   ```

5. **Para detener los servicios:**
   ```sh
   docker-compose down
   ```

---

## 5️⃣ Comandos útiles

- **Ver logs del microservicio:**
  ```sh
  docker logs -f demomicroservices
  ```

- **Eliminar contenedor:**
  ```sh
  docker rm demomicroservicio
  ```

- **Detener y eliminar si está corriendo:**
  ```sh
  docker stop demomicroservicio
  docker rm demomicroservicio
  ```

- **Verificar puertos expuestos:**
  ```sh
  sudo netstat -tuln | grep 8080
  ```

---

## 📝 Notas

- Si solo quieres desplegar la app y tienes la base de datos en RDS o fuera de Docker, ajusta la variable `SPRING_DATASOURCE_URL` en tu `docker-compose.yml` o al correr el contenedor.
- Puedes personalizar los nombres de los servicios y contenedores según tu preferencia.

---

¡Listo! Tu microservicio Java + PostgreSQL estará corriendo en AWS EC2 usando Docker Compose. 🚢🌩️