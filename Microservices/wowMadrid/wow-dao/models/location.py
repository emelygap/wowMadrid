from config import db

class Location(db.Model):
    __tablename__ = 'locations'
    
    id = db.Column(db.Integer, primary_key=True)
    latitude = db.Column(db.String(50), nullable=False)
    longitude = db.Column(db.String(50), nullable=False)

    # one-to-many relationship with Event
    events = db.relationship("Event", backref="location_events", lazy='joined')
    
    def __repr__(self):
        return f"<Location(id={self.id}, latitude='{self.latitude}', longitude='{self.longitude}')>"
    
    def dict(self):
        return {
            'id': self.id,
            'latitude': self.latitude,
            'longitude': self.longitude
        }