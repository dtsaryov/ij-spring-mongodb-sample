use ij-spring-demo

db.createCollection('person')

db.person.insertMany([
    {
        'firstname': 'Jon',
        'lastname': 'Snow',
        'age': 27,
        'visits': 5
    },
    {
        'firstname': 'Daenerys',
        'lastname': 'Targaryen',
        'age': 23,
        'visits': 12
    },
    {
        'firstname': 'Sansa',
        'lastname': 'Stark',
        'age': 25,
        'visits': 8
    }
])