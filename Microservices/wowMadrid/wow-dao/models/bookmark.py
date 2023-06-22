from config import db

class Bookmark(db.Model):
    pass
    __tablename__ = 'bookmark'
    
    user_id = db.Column(db.Integer, primary_key=True)
    event_id = db.Column(db.String(15), primary_key= True)