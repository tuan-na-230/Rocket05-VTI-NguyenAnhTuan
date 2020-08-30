const model = {}

model.callApi = async () => {
    await fetch('https://5f47b3da95646700168d9c2f.mockapi.io/api/employee')
        .then(response => response.json())
        .then(data => model.Employees = data);
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