const model = {}

model.callApi = async () => {
    await fetch('http://localhost:8080/departments')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            model.group = data
        });
}

model.groupSelected = []

model.groupDetail = null

model.creator = 'NAT'

model.group = [
    {
        id: 1,
        groupName: 'group1',
        member: [
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
        ],
        creator: 'NAT',
        createDate: new Date()
    },
    {
        id: 2,
        groupName: 'group1',
        member: [
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
        ],
        creator: 'NAT',
        createDate: ''

    },
    {
        id: 3,
        groupName: 'group1',
        member: [
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
            {
                email: 'tuan',
                userName: 'tuan',
                fullName: 'Nguyen Anh Tuan',
                department: 'new',
                joinDate: ''
            },
        ],
        creator: 'NAT',
        createDate: ''

    },
]