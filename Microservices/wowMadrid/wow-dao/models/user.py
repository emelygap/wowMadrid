from config import db

class User(db.Model):
    __tablename__ = 'users'
    
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    last_name = db.Column(db.String(100), nullable=False)
    email_address = db.Column(db.String(30), nullable=False, unique=True)
    username = db.Column(db.String(100), nullable=False)
    password = db.Column(db.String(200), nullable=False)
    profile_picture = db.Column(db.String)
    
    def __repr__(self):
        return f"<User(id={self.id}, name='{self.name}', last_name='{self.last_name}', email_address='{self.email_address}', username='{self.username}', password='{self.password}', profile_picture='{self.profile_picture}')>"
    
    def __dict__(self):
        return {
            'id': self.id,
            'name': self.name,
            'last_name': self.last_name,
            'email_address': self.email_address,
            'username': self.username,
            'password': self.password,
            'profile_picture': self.profile_picture
        }