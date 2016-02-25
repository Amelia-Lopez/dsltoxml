[[address: 'bbobby@somewhere.com', name: 'Bob Bobby'],
 [address: 'ttimmy@somewhere.com', name: 'Tim Timmy'],
 [address: 'deepthroat@nowhere.com'],
 [address: 'secret@nowhere.com']].each { destination ->
    'e-mail' {
        from 'me@somewhere.com'
        to destination.address
        subject "Orders for ${destination.name ?: 'You'}"
        body (style: 'html') {
            p 'Attack at dawn.'
        }
    }
}