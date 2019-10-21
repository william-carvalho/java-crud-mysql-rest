# java-crud-mysql-rest

## Usage

### Installation 
    Java 8 - https://start.spring.io/ (mysql + devtools + jpa + web) 
### Run
    configure DATABASE_URL=mysql://root:new_password@localhost/posts
    execute resource/init.sql
    mvn spring-boot:run
then

    curl -d '{"id":"1", "title":"Black Panther", "content":"wakanda"}' -H "Content-Type: application/json" -X POST http://localhost:8080/posts
    
# Performances with [wrk](https://github.com/wg/wrk)

    sudo apt-get install build-essential libssl-dev git -y
    git clone https://github.com/wg/wrk.git wrk
    cd wrk
    make
    # move the executable to somewhere in your PATH, ex:
    sudo cp wrk /usr/local/bin
then

    mvn spring-boot:run

then

    wrk -d1m http://localhost:8080/posts
