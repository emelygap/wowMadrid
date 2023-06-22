from config import db

class District(db.Model):
    __tablename__ = 'districts'
    
    id = db.Column(db.Integer, primary_key=True)
    district_name = db.Column(db.String(100), nullable=False, unique=True)


    addresses = db.relationship("Address", backref='district_addresses', lazy='joined')
    
    def __repr__(self):
        return f"<District(id={self.id}, district_name='{self.district_name}')>"
    
    def dict(self):
        return {
            'id': self.id,
            'district_name': self.district_name
        }