# Film rest service

| ACTION | HTTP METHOD | URL | ACCEPT | PRODUCES |
| ------ | ------ | ------ | ------ | ------ |
| get film | GET | http://localhost:8080/rest-jersey-spring/films/1 | | JSON |
| add film | POST | http://localhost:8080/rest-jersey-spring/films | application/x-www-form-urlencoded or application/json | URL to created resource |
| update film | PUT | http://localhost:8080/rest-jersey-spring/films/1 | application/json | JSON |
| delete film | DELETE | http://localhost:8080/rest-jersey-spring/films/1  | | HTTP.NO_CONTENT |
