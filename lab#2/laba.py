from fastapi import FastAPI, Request, status
from pydantic import BaseModel
import pyjokes

app = FastAPI()

class Joke(BaseModel):
    friend: str
    joke: str

class JokeInput(BaseModel):
    friend: str

@app.post("/", response_model=Joke)
def create_joke(joke_input: JokeInput):
    """Создание шутки"""
    return Joke(friend=joke_input.friend, joke=pyjokes.get_joke())


@app.get("/{friend}")
def friends_joke(friend: str):
    return friend + " tells his joke: " + pyjokes.get_joke()


@app.get("/multi/{friend}")
def multi_friends_joke(friend: str, jokes_number: int):
    result = ""
    for i in range(jokes_number):
        result += friend + f" tells his joke #{i + 1}: " + pyjokes.get_joke() + " "
    return result

class Article(BaseModel):
    title: str

@app.get("/claulator/{equation}")
def search_by_path(equation: str):
    for equation in equation.split():
        if equation != "":
            try:
                equation = equation.replace(':', '/')
                data = eval(equation)
            except:
                data = "ошибка в математическом выражении!"
                return data, status.HTTP_400_BAD_REQUEST
            return data, status.HTTP_200_OK
    return status.HTTP_500_INTERNAL_SERVER_ERROR