from app import db
from models import User

def create_user(name, last_name, email_address, username, password, profile_picture):
    user = User(name=name, last_name=last_name, email_address=email_address, username=username, password=password, profile_picture=profile_picture)
    db.session.add(user)
    db.session.commit()
    return user

def get_user_by_id(user_id):
    user = User.query.get(user_id)
    return user.__dict__() if user else None

def get_user_by_email(email):
    user = User.query.filter_by(email_address=email).first()
    return user.__dict__() if user else None

def get_user_by_username(username):
    user = User.query.filter_by(username=username).first()
    return user.__dict__() if user else None

def get_all_users():
    users = User.query.all()
    return [user.__dict__() for user in users]
