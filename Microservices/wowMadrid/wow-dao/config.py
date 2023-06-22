from flask import Flask
from flask_sqlalchemy import SQLAlchemy
db = SQLAlchemy()

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql+psycopg2://postgres:postgres@wow-postgres:5432/wow'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db.init_app(app)